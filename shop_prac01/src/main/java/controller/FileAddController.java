package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.apache.tomcat.util.http.fileupload.FileItem;

@WebServlet("/FileAddController")
public class FileAddController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UPLOAD_DIR = "file_repo";
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		File currentDirPath = new File(uploadPath); // 업로드할 경로를 File 객체로 만들기
		if (!currentDirPath.exists()) {
			currentDirPath.mkdir();
		}
		// 파일을 업로드 할 때 먼저 저장될 임시 저장경로를 설정
		// file upload시 필요한 API - commons-fileupload, commons-io
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		
		String fileName = null;
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(new ServletRequestContext(request)); 
            // 여기서부터 업로드된 파일 처리 코드 작성
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);
                    item.write(storeFile);
                }
            }
            // 파일 업로드 및 처리가 완료되면 다음 단계로 진행
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
