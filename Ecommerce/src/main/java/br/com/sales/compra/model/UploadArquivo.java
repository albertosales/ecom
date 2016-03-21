package br.com.sales.compra.model;

import java.io.File;
import java.io.FileOutputStream;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;


public class UploadArquivo {

    private String diretorio;
    private String caminho;
    private byte[] arquivo;
    private String nome;
    
    public UploadArquivo() {
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }


    public String getNome() {
        return nome;
    }

    public String getRealPath() {
        ExternalContext externalContext
                = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response
                = (HttpServletResponse) externalContext.getResponse();

        FacesContext aFacesContext = FacesContext.getCurrentInstance();
        ServletContext context
                = (ServletContext) aFacesContext.getExternalContext().getContext();

        return context.getRealPath("/");
    }

    public void fileUpload(FileUploadEvent event, String type, String diretorio) {
        try {
            this.nome = event.getFile().getFileName(); // + type;
            this.caminho = getRealPath() + diretorio + getNome();            
            this.arquivo = event.getFile().getContents();

            File file = new File(getRealPath() + diretorio);
            file.mkdirs();

        } catch (Exception ex) {
            System.out.println("Erro no upload do arquivo" + ex);
        }
    }

    public void gravar() {
        try {
            FileOutputStream fos;
            System.out.println("caminho --> "+this.caminho);
            fos = new FileOutputStream(this.caminho);
            fos.write(this.arquivo);
            fos.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
