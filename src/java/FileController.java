
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@javax.faces.bean.SessionScoped
@ManagedBean(name="fileMB")
public class FileController implements Serializable{ 
    private UploadedFile arquivo;
    private String txt;
    

    public UploadedFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
 
    public void upload(FileUploadEvent event) throws IOException { 
        FacesMessage msg = new FacesMessage("Sucesso", event.getFile().getFileName() + " foi concluído.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        arquivo = event.getFile();
        txt = new Scanner(arquivo.getInputstream(),"UTF-8").useDelimiter("\\A").next();
    }
}
