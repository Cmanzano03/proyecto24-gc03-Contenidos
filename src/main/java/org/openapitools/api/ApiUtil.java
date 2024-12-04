package org.openapitools.api;

import org.openapitools.exceptions.HttpServletResponseException;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiUtil {
    public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
        try {
            HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
            if (res != null) {
                res.setCharacterEncoding("UTF-8");
                res.addHeader("Content-Type", contentType);
                res.getWriter().print(example);
            } else {
                throw new HttpServletResponseException("HttpServletResponse is null");
            }
        } catch (IOException e) {
            throw new HttpServletResponseException("Failed to write example response to HttpServletResponse");
        }
    }
}
