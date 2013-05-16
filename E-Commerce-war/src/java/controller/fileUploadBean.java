package controller;

import java.io.File;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.richfaces.event.FileUploadEvent;

/**
 * @author Ilya Shaikovsky
 *
 */
@ManagedBean
@SessionScoped
public class fileUploadBean implements Serializable {

    //private String destination = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/");
    public void upload(FileUploadEvent event) {
        try {
            // String targetFolder ="faces/resources/images/";
            String destination = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/../../web/resources/images");
            //destination += "../../web/resources/images";
            InputStream inputStream = event.getUploadedFile().getInputStream();
            System.out.println("folder: " + destination);
            OutputStream out = new FileOutputStream(new File(destination, event.getUploadedFile().getName()));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}