package servlet;

import com.google.gson.Gson;
import data.UserBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/register.do")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");

        /*判断request 的请求方式是否为post并且contentType是否以multipart/开头
         *
         * 如果不是说明是普通的表单提交
         * */
        if (!ServletFileUpload.isMultipartContent(request)) {
            return;
        }

        /*创建一个DiskFileItemFactory对象，这里我们使用默认配置*/
        DiskFileItemFactory factory = new DiskFileItemFactory();
        /*创建一个ServletFileUpload对象*/
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

        try {

            /*解析request对象，返回FileItem集合*/
            List<FileItem> items = servletFileUpload.parseRequest(request);

            /*创建一个UserBean  用于封装用户数据*/
            UserBean userBean = new UserBean();

            /*该集合用于存储提交的爱好数据*/
            List<String> hobbyList = new ArrayList<>();


            /*遍历FileItem集合*/
            for (FileItem item : items) {

                String filedName = item.getFieldName();//获取name属性

                System.out.println("filedName=" + filedName);

                if (item.isFormField()) {
                    /*处理表单项*/
                    String value = item.getString("utf-8");

                    System.out.println("value=" + value);

                    if (filedName.equals("account")) {
                        userBean.setAccount(value);
                    } else if (filedName.equals("pwd")) {
                        userBean.setPwd(value);
                    } else if (filedName.equals("gender")) {
                        userBean.setGender(value);
                    } else if (filedName.equals("hobbies")) {
                        hobbyList.add(value);
                    }

                } else {
                    /*处理文件上传*/

                    if (filedName.equals("img")) {
                        /*获取上传文件的名字*/
                        String fileName = item.getName();
                        System.out.println("上传的文件名称为：" + fileName);

                        /*获取后缀名*/
                        int index = fileName.lastIndexOf(".");
                        String endWith = fileName.substring(index);
                        System.out.println("后缀名：" + endWith);
                        /*重新命名*/
                        String newFileName = System.currentTimeMillis() + endWith;
                        System.out.println("新文件名称：" + newFileName);

                        String path = getServletContext().getRealPath("./") + File.separator + "upload";


                        /*保存文件*/
                        File dir = new File(path);
                        if (!dir.exists()) {
                            System.out.println("文件夹不存在  创建");
                            dir.mkdir();
                        }
                        String filePath = path + File.separator + newFileName;
                        File file = new File(filePath);
                        item.write(file);
                        userBean.setImg(filePath);

                    }

                }

            }

            userBean.setHobbies(hobbyList);
            System.out.println("注册完成" + userBean.toString());

            /*保存注册的数据*/
            List<UserBean> userList = (List<UserBean>) getServletContext().getAttribute("userList");
            userList.add(userBean);
            /*返回注册信息*/
            response.getWriter().append("<h1>");
            response.getWriter().append("注册成功：" + new Gson().toJson(userBean));
            response.getWriter().append("</h1>");

            System.out.println("目前注册的用户个数：" + userList.size());


        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
