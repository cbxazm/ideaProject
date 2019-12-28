package cn.cbx.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileUpLoad(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断，该路径是否存在
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item:items ){
            System.out.println(item);
           //判断是普通表单项还是文件项“
            if(item.isFormField()){
                //是普通表单项

            }else {
                 //上传文件项
                String filename = item.getName();
                System.out.println(filename);
                //把文件名称设置成唯一的值，uuid
                String s = UUID.randomUUID().toString().replace("-","");
                System.out.println(s);
                filename=s+"_"+filename;
                //完成文件上传
                item.write(new File(path,filename));
                    //删除临时文件(上传文件大于10kb，就会有临时文件，小于10kb，在内存中生成缓存的一个文件)
                item.delete();
            }
        }
        return "success";
    }

    /**
     * springmvc上传文件的方式
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload2")
//    MultipartFile upload这个名字必须跟表单的那个name是一样的
    public String fileUpLoad(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断，该路径是否存在
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        String filename = upload.getOriginalFilename();
        String uuid=UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;
        upload.transferTo(new File(path,filename));
        return "success";
    }
}
