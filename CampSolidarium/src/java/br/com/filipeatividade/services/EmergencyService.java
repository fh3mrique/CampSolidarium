package br.com.filipeatividade.services;

import br.com.filipeatividade.entities.Emergency;
import br.com.filipeatividade.repository.EmergencyRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmergencyService {

    public static void showDetails(HttpServletRequest request, HttpServletResponse response, Emergency emergency)
            throws ServletException, IOException {
        request.setAttribute("emergency", emergency);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudEmergency/detailsEmergency.jsp");
        dispatcher.forward(request, response);
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response, Emergency emergency)
            throws ServletException, IOException {
        request.setAttribute("emergency", emergency);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudEmergency/editEmergency.jsp");
        dispatcher.forward(request, response);
    }

    public static void deleteEmergency(HttpServletRequest request, HttpServletResponse response, Emergency emergency)
            throws ServletException, IOException {
        EmergencyRepository.delete(emergency);
        showUpdatedMessage(request, response);
    }

    public static void showEmergenciesList(HttpServletRequest request, HttpServletResponse response, List<Emergency> emergencies)
            throws ServletException, IOException {
        request.setAttribute("emergencies", emergencies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudEmergency/emergencyList.jsp");
        dispatcher.forward(request, response);
    }

    public static void showUpdatedMessage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudEmergency/updateMessage.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateEmergency(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Emergency emergency = EmergencyRepository.find(id);

        emergency.setLocal(request.getParameter("local"));
        emergency.setDescription(request.getParameter("description"));
        emergency.setSeverityLevel(request.getParameter("severityLevel"));
        emergency.setType(request.getParameter("type"));

        EmergencyRepository.update(emergency);

        showUpdatedMessage(request, response);
    }
}
