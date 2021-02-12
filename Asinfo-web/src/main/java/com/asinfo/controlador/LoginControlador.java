/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.controlador;

import com.asinfo.dao.UsuarioDao;
import com.asinfo.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Marco
 */
@Named(value = "loginControlador")
@SessionScoped
public class LoginControlador implements Serializable {

    @EJB
    private UsuarioDao usuarioDao;

    @Getter
    @Setter
    private Usuario usuario;

    @Getter
    @Setter
    private String usuUsuario;

    @Getter
    @Setter
    private String usuPassword;

    @Getter
    @Setter
    private HttpSession session;

    public LoginControlador() {
        usuario = new Usuario();
        usuUsuario = "";
        usuPassword = "";
    }

    public void login() throws IOException {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            usuario = usuarioDao.buscarPorUsuarioPorPassword(usuUsuario, usuPassword);
            if (usuario != null) {
                //datos de sesion: primera alternativa
                context.getExternalContext().getSessionMap().put("user", usuario);
                //datos de sesion: segunda alternativa (con HttpSession)
                session = (HttpSession) context.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("user", usuario);
                // redirigir
                context.addMessage(null, new FacesMessage("éxito", "Bienvenido"));
                context.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/paginas/supervisor.xhtml");
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos", null);
                context.addMessage(null, message);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void logout() throws IOException {
        //forma 1
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuario = new Usuario();
        //con HttpSession
        //session.removeAttribute("user");
        //redirigir
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/login.xhtml");
    }

}
