package com.tang.Config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ASUS
 * @create 2019-02-03 11:41
 */
public class UploadFile extends HttpServlet {

    private static String filePath = "G:\\Intell Worker\\programe_take\\programe_take-web\\target\\classes\\static\\upload";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part file = request.getPart("file");

        String[] split = file.getSubmittedFileName().split("\\.");

        String newFileName = UUID.randomUUID().toString().substring(10)+"."+split[1];

        file.write(filePath + File.separator+newFileName);

        response.getWriter().print("/upload/"+newFileName);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    }
}
