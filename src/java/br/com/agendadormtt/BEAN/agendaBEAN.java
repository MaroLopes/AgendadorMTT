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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

    
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    public void chamaNovoAgendamento() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        RequestContext.getCurrentInstance().openDialog("formNovoAgendamento", options, null);
    }
    
    public void testeAgendamento() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
         
        RequestContext.getCurrentInstance().openDialog("formNovoAgendamento", options, null);
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
    }
    
}
