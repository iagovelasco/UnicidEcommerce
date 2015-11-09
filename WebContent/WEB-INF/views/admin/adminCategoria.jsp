
<%@ include file="../commonAdmin/headerAdmin.jspf"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.connectedToys.bean.Categoria"%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../commonAdmin/sidebarAdmin.jspf"%>
        </div>
     	<div class="span9" >
            <div class="well" align="center">
                
                
                <div class="page-header" >
                    <h1>Área Categoria</h1>
                </div>
                
                <table class="table table-bordered table-striped table-todo" >
                
                                   
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Linha</th>
                        <th>Faixa Etária</th>
                        <th>Ação</th>
                    </tr>
                   <tbody>
                   <%
					ArrayList<Categoria> lista = new ArrayList<Categoria>();
					lista = (ArrayList) request.getAttribute("categoria");
					for (Categoria categoria : lista) {
					%>
					<tr>
						<td><%=categoria.getId()%></td>
						<td><%=categoria.getNome()%></td>
						<td><%=categoria.getGenero()%></td>
						<td><%=categoria.getFaixaEtaria() %>
						
							<td class="actions">
				  <a class="btn btn-mini btn-primary" href="updateCateg?id=<%=categoria.getId()%>"><i class="icon-edit icon-white"></i> Editar</a>
				   			
				  <a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_<%=categoria.getId()%>"><i class="icon-remove icon-white"></i> Deletar</a>
					
						 <div class="modal hide" id="confirm_delete_<%=categoria.getId()%>">
						   <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">×</button>
	                                        <h3>Confirmação</h3>
	                                    </div>
	                                    <div class="modal-body">
	                                        <p>Tem certeza que deseja deletar a categoria <%=categoria.getId()%> : <%=categoria.getNome()%> ?</p>
	                                    </div>
	                                    <div class="modal-footer">
	                                        <form action="deleteCategoria.do" method="post">
	                                            <input type="hidden" name="id" value="<%=categoria.getId()%>">
	                                            <a href="#" class="btn" data-dismiss="modal">Cancelar</a> <button  type="submit" class="btn btn-primary">Confirmar</button>
	                                        </form>
	                                    </div>
	                                </div>
				</td>	
				 
			</tr>			
					
					<%}%>
                   
                    </tbody>              
                </table>      
                   <a href="newCategoria" class="btn btn-primary"><i class="icon-ok icon-white"></i>Criar Categoria</a>     
            </div>
        </div>
    </div>
</div>

<%@ include file="../commonAdmin/footerAdmin.jspf"%>
