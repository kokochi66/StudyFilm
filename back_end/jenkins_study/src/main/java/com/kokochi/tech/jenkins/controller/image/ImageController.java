package com.kokochi.tech.jenkins.controller.image;

import com.kokochi.tech.jenkins.controller.image.model.ImageDto;
import com.kokochi.tech.jenkins.controller.product.model.ProductDto;
import com.kokochi.tech.jenkins.domain.product.ProductImg;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/image")
@AllArgsConstructor
@Slf4j
public class ImageController {

}
