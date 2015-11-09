<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.connectedToys.bean.Produto"%>
<%@ page import="br.com.connectedToys.dao.ProdutoDAO"%>
<%@ include file="../commonUser/header.jspf"%>
<div class="container">
    <div class="row" id="teste">
        <div class="span3">
            <%@ include file="../commonUser/sidebar.jspf"%>
        </div>
     	<div class="span10" >
            <div class="well" align="center">
                

           
                <div class="page-header" >
                    <h1>Sobre</h1>
                </div>
                <table class="table table-bordered table-striped">
                    <tbody>                 
                    <tr>
                        <td colspan="2"><strong>Participantes do Projeto</strong></td>
                    </tr>
                    <tr>
                        <td>Alexandre Hideki - 13030639</td>
                        <td><a href="https://github.com/AlexandreHSato">https://github.com/AlexandreHSato</a></td>
                    </tr>
                    <tr>
                        <td>Emerson Holanda - 13039601</td>
                        <td><a href="https://github.com/ehandrade">https://github.com/ehandrade</a></td>
                    </tr>
                    <tr>
                        <td>Iago Velasco - 13030981</td>
                        <td><a href="https://github.com/iagovelasco">https://github.com/iagovelasco</a></td>
                    </tr>
                    <tr>
                        <td>Lucas N. Munhoz - 13030965</td>
                        <td><a href="https://github.com/lnmunhoz">https://github.com/lnmunhoz</a></td>
                    </tr>
                    <tr>
                        <td>Rodrigo Martins Granata - 13031279</td>
                        <td><a href="https://github.com/rdomartins">https://github.com/rdomartins</a></td>
                    </tr>
                    </tbody>
                </table>
                 
           	</div>
           	</div>
           	</div>
           	</div>


<%@ include file="../commonUser/footer.jspf"%>
