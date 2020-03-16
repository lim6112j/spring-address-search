package com.onsemiro.addresssearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Log
@Controller
public class GreetingController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("addrsearch", new Addrsearch());
        return "greeting";
    }
    @RequestMapping(value = "/getAddress", method = RequestMethod.POST)
    public String greeting(@ModelAttribute Addrsearch addrsearch, BindingResult errors, Model model) throws JsonProcessingException {
//        log.info(addrsearch.getKeywd());
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("keyword", addrsearch.getKeywd());
        map.add("confmKey", "U01TX0FVVEgyMDIwMDMxNjEyMDA1OTEwOTU0NzI=");
        map.add("returnUrl", "http://localhost:8080");
        map.add("currentPerPage", "10");
        map.add("resultType", "json");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        final String uri = "http://www.juso.go.kr/addrlink/addrLinkApi.do";
        ResponseEntity<AddrResult> res = restTemplate.postForEntity(uri, request, AddrResult.class);
        log.info(res.getBody().getResults().getJuso().toString());
        model.addAttribute("addrs", res.getBody().getResults().getJuso());
        return "greeting";
    }
    @RequestMapping(value="/select", method=RequestMethod.POST)
    public String select(@RequestParam("address") String address, @ModelAttribute DetailAddr detailAddr, Model model) throws JsonProcessingException {
        log.info(address);
//        JsonNode juso = objectMapper.readTree(address);
        model.addAttribute("address", address);
        return "selection";
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest req, HttpServletResponse res, Model model) {
        log.info(req.getParameter("detail"));
        log.info(req.getParameter("address"));
//        model.addAttribute("detailAddr", detailAddr);
//        log.info(detailAddr.getDetail());
        return "finish";
    }
}
