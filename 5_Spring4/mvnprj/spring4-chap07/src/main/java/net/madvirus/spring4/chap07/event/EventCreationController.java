package net.madvirus.spring4.chap07.event;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("eventForm")
// 스프링에서 임시 용도로 사용할 데이터를 세션에 보관할 때 사용할 수 있는 @SessionASttribute 어노테이션
// 어노테이션을 사용해서 지정한 이름을 이용해서 임시 목적으로 사용될 객체를 세션에 보관하게 된다.
public class EventCreationController {

	private static final String EVENT_CREATION_STEP1 = "event/creationStep1";
	private static final String EVENT_CREATION_STEP2 = "event/creationStep2";
	private static final String EVENT_CREATION_STEP3 = "event/creationStep3";
	private static final String EVENT_CREATION_DONE = "event/creationDone";

//	@RequestMapping("/newevent/step1")
//	public String step1(Model model) {
//		model.addAttribute("eventForm", new EventForm());
//		return EVENT_CREATION_STEP1;
//	}
	// @SessionAttributes가 동작하기 위해서, 모델에서 같은 이름을 갖는 객체를 추가하여, 초기화해준다.

	@ModelAttribute("eventForm")
	public EventForm formData() {
		return new EventForm();
	} // @ModelAttribute를 이용해서도 세션에 보관할 객체를 생성할 수 있다.

	@RequestMapping("/newevent/step1")
	public String step1() {
		return EVENT_CREATION_STEP1;
	}
		
	@RequestMapping(value = "/newevent/step2", method = RequestMethod.POST)
	public String step2(@ModelAttribute("eventForm") EventForm formData, BindingResult result) {
		new EventFormStep1Validator().validate(formData, result);
		if (result.hasErrors())
			return EVENT_CREATION_STEP1;
		return EVENT_CREATION_STEP2;
	}

	@RequestMapping(value = "/newevent/step2", method = RequestMethod.GET)
	public String step2FromStep3(@ModelAttribute("eventForm") EventForm formData) {
		return EVENT_CREATION_STEP2;
	}

	@RequestMapping(value = "/newevent/step3", method = RequestMethod.POST)
	public String step3(@ModelAttribute("eventForm") EventForm formData, BindingResult result) {
		ValidationUtils.rejectIfEmpty(result, "target", "required");
		if (result.hasErrors())
			return EVENT_CREATION_STEP2;
		return EVENT_CREATION_STEP3;
	}

	@RequestMapping(value = "/newevent/done", method = RequestMethod.POST)
	public String done(@ModelAttribute("eventForm") EventForm formData, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return EVENT_CREATION_DONE;
	}

}
