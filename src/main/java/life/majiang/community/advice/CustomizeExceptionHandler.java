package life.majiang.community.advice;

import life.majiang.community.dto.ResultDTO;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    Object handle(HttpServletRequest request, Throwable e, Model model) {

        String contentType = request.getContentType();

        if("application/json".equals(contentType)){
            // 返回 JSON
            if (e instanceof CustomizeException) {
                return ResultDTO.errorOf((CustomizeException)e);
            }else{
                return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
        }else{
            // 错误页面跳转
            if (e instanceof CustomizeException) {
                model.addAttribute("message",e.getMessage());
            }else{
                model.addAttribute("message",CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
