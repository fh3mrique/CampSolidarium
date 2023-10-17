/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.controllers;

import br.com.filipeatividade.entities.Emergency;
import br.com.filipeatividade.repository.EmergencyRepository;
import br.com.filipeatividade.services.EmergencyService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EmergencyServlet", urlPatterns = {"/EmergencyServlet"})
public class EmergencyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        if (id != null){
            
            Emergency emergency = EmergencyRepository.find(Long.parseLong(id));
            
            String operacao = request.getParameter("operacao");
            
            if ("edit".equals(operacao)){
                EmergencyService.showEditForm(request, response, emergency);
            }
            else if ("delete".equals(operacao)){
                EmergencyService.deleteEmergency(request, response, emergency);
            }
            else {
                EmergencyService.showDetails(response, emergency);
            }  
        }
        
        else {
            List<Emergency> emergencies = EmergencyRepository.findAll();
            EmergencyService.showEmergenciesList(response, emergencies);
        }
                   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long id = Long.parseLong(request.getParameter("codigo"));

        Emergency insumo = EmergencyRepository.find(id);

        insumo.setLocal(request.getParameter("local"));
        insumo.setDescription(request.getParameter("description"));
        insumo.setSeverityLevel(request.getParameter("severityLevel"));
        insumo.setType(request.getParameter("type"));

        EmergencyRepository.update(insumo);

        EmergencyService.showUpdatedMessage(response);
           
    }

}
