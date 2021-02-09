package com.zht.control;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @Author : Zht
 * @Organization : U know Who
 * @Title :
 * @Description :
 * @Date : 2021/2/79:24
 */
@RestController
@RequestMapping("commerceInfoColService")
public class CommerceInfoColService {

    @PostMapping("/webInfoColService")
    public void webInfoColService(@RequestBody String jsonString, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Hi, welcome " + jsonString);
//        业务开始

//        业务结束
        PrintWriter writer = getWriter(response);
        response.setStatus(HttpStatus.OK.value());
        writer.write("sucess");
        closePrintWriter(writer);
    }

    private PrintWriter getWriter(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        OutputStream out = null;
        PrintWriter printWriter = null;
        try {
            out = response.getOutputStream();
            printWriter = new PrintWriter(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return printWriter;
    }

    private void closePrintWriter(PrintWriter printWriter) {
        printWriter.flush();
        printWriter.close();
    }
}
