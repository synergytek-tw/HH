<%
Runtime rt= Runtime.getRuntime();
%>
Free Memory:<%=rt.freeMemory()%><br>
Max Memory:<%=rt.maxMemory()%><br>
Total Memory:<%=rt.totalMemory()%><br>