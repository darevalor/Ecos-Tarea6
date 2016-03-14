<!DOCTYPE html>
<html lang="en">
    <head>
        <title>File Upload</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form method="POST" action="upload" enctype="multipart/form-data">
            <table style="width: 50%" border="1">
                <tr>
                    <td colspan="2">
                        <h2>Cargar un archivo .txt con los valores separados por punto y coma. 
                            <br><br>
                        </h2>
                        <ul>
                            <li>Antes de relacionar la tabla de Clases dejar una linea con el titulo LOC/Method Data</li>
                            <li>Antes de relacionar la tabla de Capitulos dejar una linea con el titulo Pgs/Chapter</li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>
                        Archivo: 
                    </td>
                    <td>
                        <input type="file" name="file" id="file" /> <br/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Cargar" name="upload" id="upload" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>