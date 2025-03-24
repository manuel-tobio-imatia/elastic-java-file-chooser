<%@ include file="header.jsp"%>

<%@ page language="java" import="java.io.*" errorPage=""%>
<link rel="stylesheet" type="text/css" href="css/datatables.min.css" />
<script src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/datatables.min.js"></script>

<article>
	<section>
		<div align="center" style="overflow-x: auto;"">
			<script>
            $(document).ready(function() {
             $('#example').DataTable();
            } );
          </script>
			<table id="example" class="display" cellspacing="0">
				<%
           String csvName = request.getParameter("csv");
           String fName = servletContext.getRealPath("/webstart/changelog/" + csvName);
           String thisLine;
           int count=0;
           FileInputStream fis = new FileInputStream(fName);
           DataInputStream myInput = new DataInputStream(fis);
           int i=0;

           %><thead>
					<tr>
						<%
           if((thisLine = myInput.readLine()) != null) {
             String strar[] = thisLine.split(";");

             for(int j=0;j<strar.length;j++)  {
               if(i!=0) {
                 out.print("<th> " +strar[j]+ "</th> ");
               }
               else {
                 out.print(" <th> <b>" +strar[j]+ "</b> </th> ");
               }
               i++;
             }
           }
           %>
					
				</thead>
				</tr>

				<tbody>
					<%
           while ((thisLine = myInput.readLine()) != null) {
              String strar[] = thisLine.split(";");
              %><tr>
						<%
              for(int j=0;j<strar.length;j++)  {
                if(i!=0) {
                  out.print("<td> " +strar[j]+ "</td> ");
                }
                else {
                  out.print(" <td> <b>" +strar[j]+ "</b> </td> ");
                }
                i++;
              }
              %>
					</tr>
					<%
            }
           %>
				</tbody>
			</table>
		</div>
	</section>
</article>

<%@ include file="footer.jsp"%>
