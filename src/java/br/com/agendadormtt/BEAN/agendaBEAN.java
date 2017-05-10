/*
 * To change this license header, choose Lipublic void openLevel3() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("level3", options, null);
    }cense Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendadormtt.BEAN;

import br.com.agendadormtt.DAO.AgendaDAO;
import br.com.agendadormtt.VO.Agenda;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author mlopes
 */
@ManagedBean (name="agendaBean")
@SessionScoped
public class agendaBEAN {

    private Date data1;
    private Agenda agenda = new Agenda();  
    private List<Agenda> agendas;
    private List<Agenda> selectedAgendas;
    private String teste;

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
    
    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }
    /** 
     * Creates a new instance of agendaBEAN
     */
    public agendaBEAN() {
        data1 = new Date();
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<Agenda> getSelectedAgendas() {
        return selectedAgendas;
    }

    public void setSelectedAgendas(List<Agenda> selectedAgendas) {
        this.selectedAgendas = selectedAgendas;
    }
    
    public List<Agenda> getAgendas() {
        
        AgendaDAO dao = new AgendaDAO();
                
        try {
            
            List<Agenda> lista = dao.GetData(data1);
            agendas = lista;
        } catch (Exception e) {
            
        }
        return agendas;
    }
    
    public void addAgenda(){
        
        try {
            
            AgendaDAO dao = new AgendaDAO();
            dao.salvar(agenda);
            RequestContext.getCurrentInstance().closeDialog(this);
            sendMail(agenda);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteAgenda(){
        
        try {
            if (selectedAgendas.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleta:", "Selecione agendamentos para deleta-los"));
            }else{
                for (Agenda a : selectedAgendas) {
                    AgendaDAO dao = new AgendaDAO();
                    dao.delete(a);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Agendas selecionadas deletadas com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados", e.getMessage()));
        }
        
    }
    
    public void updateAgenda(){
        
        try {
            
            AgendaDAO dao = new AgendaDAO();
            dao.update(agenda);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Agenda atualizada com sucesso!"));
        } catch (Exception e) {
            
        }
        
    }
    
    public void novoAgendamento() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        agenda = new Agenda();
        RequestContext.getCurrentInstance().openDialog("frmNovoAgendamento", options, null);
        
    }
    
    public void editarAgendamento() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        
        if (selectedAgendas.size() == 1) {
            agenda = selectedAgendas.get(0);
            RequestContext.getCurrentInstance().openDialog("frmEditarAgendamento", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione uma Agenda a ser Editada!"));
        }
        
    }
    
    public void filtroDataTable(SelectEvent e) {
        
        data1 = (Date)e.getObject();
        
    }
    
    public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
    public void sendMail(Agenda a) throws EmailException{
        SimpleEmail email = new SimpleEmail();
        //Utilize o hostname do seu provedor de email
        email.setHostName("mail.ensel.com.br");
        //Quando a porta utilizada não é a padrão (gmail = 465)
        email.setSmtpPort(26);
        //Adicione os destinatários
        email.addTo("corporativo.spo@ensel.com.br", "Corporativo - SPO");
        //Configure o seu email do qual enviará
        email.setFrom("corporativo.spo@ensel.com.br", "Corporativo - SPO");
        //Adicione um assunto
        email.setSubject("(Teste Aplicação) - Chamado " + a.getAgendaId() + "- Data " + formatarData(a.getAgendaData()) + " - Hora " + formatarHora(a.getAgendaHora())
                + " - Projeto " + a.getAgendaProjetoId() + " - " + a.getAgendaSolicitante() + " - " + a.getAgendaCidade() + " - " + a.getAgendaUf());
        //Adicione a mensagem do email
        email.setMsg(a.getAgendaDescricaoAtividade());
        //Para autenticar no servidor é necessário chamar os dois métodos abaixo
        email.setSSL(false);
        email.setAuthentication("corporativo.spo@ensel.com.br", "dwm=11");
//        System.out.println("enviando...");
        email.send();
//        System.out.println("Email enviado!");
    }
    
    public String formatarData(Date d) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(d);
    }
    
    public String formatarHora(Date h) {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
        return formato.format(h);
    }
    
}
