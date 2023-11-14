package br.com.filipeatividade.controllers;

import br.com.filipeatividade.entities.Insumo;
import br.com.filipeatividade.repository.InsumoRepository;
import br.com.filipeatividade.services.InsumoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InsumoServlet", urlPatterns = {"/InsumoServlet"})
public class InsumoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recupera o id do insumo da solicitação
        String id = request.getParameter("id");

        // Recupera a operação da solicitação
        String operacao = request.getParameter("operacao");

        // Obtém os insumos do repositório
        List<Insumo> insumos = InsumoRepository.findAll();

        if (id != null) {

            // Se o id estiver presente, recupera o insumo do repositório
            Insumo insumo = InsumoRepository.find(Long.parseLong(id));

            // Encaminha a solicitação para o arquivo JSP apropriado
            if (operacao.equals("detalhar")) {
                InsumoService.showDetails(request, response, insumo);
            } else if (operacao.equals("editar")) {
                InsumoService.showEditForm(request, response, insumo);
            } else if (operacao.equals("excluir")) {
                InsumoService.deleteInsumo(request, response, insumo);
            }

        } else {

            // Se o id não estiver presente, encaminha a solicitação para o arquivo JSP apropriado
            InsumoService.showInsumosList(request, response, insumos);;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recupera o código do insumo da solicitação
        Long id = Long.parseLong(request.getParameter("codigo"));

        // Obtém o insumo do repositório
        Insumo insumo = InsumoRepository.find(id);

        // Atualiza os dados do insumo
        insumo.setName(request.getParameter("nome"));
        insumo.setBrand(request.getParameter("marca"));
        insumo.setCategory(request.getParameter("categoria"));
        insumo.setQtd(Integer.parseInt(request.getParameter("quantidade")));

        // Atualiza o insumo no repositório
        InsumoRepository.update(insumo);

        // Encaminha a solicitação para o arquivo JSP apropriado
        InsumoService.showUpdatedMessage(request, response);
    }
}
