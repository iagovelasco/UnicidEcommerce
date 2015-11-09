
<%@ include file="../commonAdmin/headerAdmin.jspf"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.connectedToys.bean.Administrador"%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../commonAdmin/sidebarAdmin.jspf"%>
        </div>
     	<div class="span9" >
     	  
            <div class="well" align="center">
                
                
                <div class="page-header" >
                    <h1>Área Administradores Cadastrados</h1>
                </div>
                
                <table class="table table-bordered table-striped table-todo" >
                
                                   
                    <tr>
                    	<th>Código</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Ação</th>
                    </tr>
                   <tbody>
                   <%
					ArrayList<Administrador> lista = new ArrayList<Administrador>();
					lista = (ArrayList) request.getAttribute("administradores");
					for (Administrador admin : lista) {
					%>
					<tr>
						<td><%=admin.getId()%></td>
						<td><%=admin.getNome()%></td>
						<td><%=admin.getEmail()%></td>
							<td class="actions">
				  <a class="btn btn-mini btn-primary" href="updateAdmin?id=<%=admin.getId()%>"><i class="icon-edit icon-white"></i> Editar</a>
				   			
				  <a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_<%=admin.getId()%>"><i class="icon-remove icon-white"></i> Deletar</a>
					
						 <div class="modal hide" id="confirm_delete_<%=admin.getId()%>">
						   <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">×</button>
	                                        <h3>Confirmação</h3>
	                                    </div>
	                                    <div class="modal-body">
	                                        <p>Tem certeza que deseja deletar o administrador <%=admin.getId()%> : <%=admin.getNome()%> ?</p>
	                                    </div>
	                                    <div class="modal-footer">
	                                        <form action="delete.do" method="post">
	                                            <input type="hidden" name="id" value="<%=admin.getId()%>">
	                                            <a href="#" class="btn" data-dismiss="modal">Cancelar</a> <button  type="submit" class="btn btn-primary">Confirmar</button>
	                                        </form>
	                                    </div>
	                                </div>
				</td>	
				 
			</tr>			
					
					<%}%>
                   
                    </tbody>              
                </table>     
                   <a href="newAdministrator" class="btn btn-primary"><i class="icon-ok icon-white"></i>Criar Administrador</a>     
            </div>
        </div>
    </div>
</div>

<%@ include file="../commonAdmin/footerAdmin.jspf"%>
