<%@ include file="header.jsp"%>

<article>
	<section>
		<div class="rTable">
			<div class="rTableRowSpace">
				<script>
                document.write('<a href=' + jnlp + ' ><img width="50%"" height="auto" src=' + logo + ' border=0></a>');
              </script>
			</div>

			<div id="downloadImages">
				<script>
                getDownloadIcon(jnlp, "images/download_arrow_icon.png");
              </script>
			</div>
			<div id="downloadImages">Descarga</div>
		</div>
	</section>
</article>

<%@ include file="footer.jsp"%>
