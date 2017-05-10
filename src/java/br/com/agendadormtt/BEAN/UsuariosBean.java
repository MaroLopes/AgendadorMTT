package br.com.agendadormtt.BEAN;

import br.com.agendadormtt.DAO.UsuariosDAO;
import br.com.agendadormtt.VO.Usuarios;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author mlopes
 */
@ManagedBean(name="userBean")
@SessionScoped
public class UsuariosBean {
    
    private Usuarios usuario = new Usuarios();
    
    private List<Usuarios> usuarios;
    private List<Usuarios> selectedUsuarios;

    public List<Usuarios> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(List<Usuarios> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }

    public List<Usuarios> getUsuarios() {
        
        UsuariosDAO dao = new UsuariosDAO();
                
        try {
            
            List<Usuarios> lista = dao.GetALL();
            usuarios = lista;
        } catch (Exception e) {
            
        }
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public void addUsuario(){
        
        try {
            
            UsuariosDAO dao = new UsuariosDAO();
            dao.salvar(usuario);
            RequestContext.getCurrentInstance().closeDialog(this);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Usuário Cadastrado com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteUsuario(){
        
        try {
            if (selectedUsuarios.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleta:", "Selecione Usuários para deleta-los"));
            }else{
                for (Usuarios u : selectedUsuarios) {

                    UsuariosDAO dao = new UsuariosDAO();
                    dao.delete(u);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Usuários deletados com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados", e.getMessage()));
        }
        
    }
    
    public void updateUsuario(){
        
        try {
            
            UsuariosDAO dao = new UsuariosDAO();
            dao.update(usuario);
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void inserirUsuário() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("frmCadastroUsuario", options, null);

    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
}
