# Indicamos la imagen base
FROM python:latest

# Establecer el directorio de trabajo
WORKDIR /Docker1

# Copiar los archivos necesarios al contenedor
COPY app.py .

# Puerto de la aplicacion (contenedor)
EXPOSE 5000

# Comandos dentro del contenedor
RUN pip install flask

#  Ejecutar la aplicacion en el contenedor
CMD ["python", "app.py"] 