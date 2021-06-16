package net.madvirus.spring4.chap07.event;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/event")
public class EventController {
	private static final String REDIRECT_EVENT_LIST = "redirect:/event/list";
	private EventService eventService;

	public EventController() {
		eventService = new EventService();
	}

	@ModelAttribute("recEventList")
	public List<Event> recommend() {
		return eventService.getRecommendedEventService();
	}

	@RequestMapping("/list")
	public String list(SearchOption option, Model model) {
		List<Event> eventList = eventService.getOpenedEventList(option);
		model.addAttribute("eventList", eventList);
		model.addAttribute("eventTypes", EventType.values());
		return "event/list";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// 컴내드 객체의 Date 타입 프로퍼티에 파라미터 값을 할당할 떄 사용한다.
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
		// CustomDateEditor 객체를 WebDataBinder에 등록해준다. Date타입의 프로퍼티로 값을 변환할떄 해당 에디터를 사용한다는 뜻이다.
		// 프로퍼티마다 다른 에디터를 적용하고 싶으면, 중간에 프로퍼티 이름을 문자열로 넣어주면 된다.
	}

	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) throws IOException {
		String id = request.getParameter("id");
		// @RequestMapping 메서드에 HttpServletRequest타입의 인자를 구하고 이를 통해서 요청 파라미터를 구한다.
		
		if (id == null)
			return REDIRECT_EVENT_LIST;
		Long eventId = null;
		try {
			eventId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return REDIRECT_EVENT_LIST;
		}
		Event event = getEvent(eventId);
		if (event == null)
			return REDIRECT_EVENT_LIST;

		model.addAttribute("event", event);
		return "event/detail";
	}

	private Event getEvent(Long eventId) {
		return eventService.getEvent(eventId);
	}

	@RequestMapping("/list2")
	public ModelAndView list2(SearchOption option) {
		List<Event> eventList = eventService.getOpenedEventList(option);
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("event/list");
		modelView.addObject("eventList", eventList);
		modelView.addObject("eventTypes", EventType.values());
		return modelView;
	}

	@RequestMapping("/detail2")
	public String detail2(@RequestParam("id") long eventId, Model model) {
		// @RequestParam 어노테이션을 사용해서, 메서드의 파라미터를 이용해서 HTTP 요청 파라미터를 받을 수 있다.
		Event event = getEvent(eventId);
		if (event == null)
			return REDIRECT_EVENT_LIST;
		model.addAttribute("event", event);
		return "event/detail";
	}
}
