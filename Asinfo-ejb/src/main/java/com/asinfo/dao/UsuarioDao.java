/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.dao;

import com.asinfo.generico.Generico;
import com.asinfo.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Marco
 */
@LocalBean
@Stateless
public class UsuarioDao extends Generico<Usuario> implements Serializable {

    public Usuario buscarPorUsuarioPorPassword(String usuario, String password) {
        Query q;
        q = getEntityManager().createQuery("SELECT u FROM Usuario u "
                + " WHERE u.usuUsuario =:usuario "
                + " AND u.usuPassword =:password");
        q.setParameter("usuario", usuario);
        q.setParameter("password", password);
        q.setMaxResults(1);
        try {
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
