# The-SGR-Project
Oct 2020 - Presente

Proyecto de Gestión de una SGR, (Sociedad de Garantías Recíprocas).

Implementación diseñada con compentes Swing, desarrollada para llevar a cabo las siguientes tareas:
Control de nuevos y antiguos miembros.
Control de las operaciones diarias.
Consultas generales.
Registro de operaciones.

Consultas generales:

	Total de comisiones calculadas en un día por operaciones de cheques presentadas en el Mercado Argentino de Valores 
	Las operaciones avaladas a nombre de un socio, en estado monetizadas en un período de tiempo 
	Valor promedio de la tasa de descuento y total operado de cheques y pagarés para un tipo de empresa (pequeña, mediana, grande), en un período de tiempo 
	Consulta porcentaje de comisión a calcularle a un socio por un tipo de operación pasada por parámetros 
	Consulta consolidada de un socio. Consultas riesgo vivo y total de utilizado. Total y detalle

Logica interna (Reglas de la SGR):

	Ningún socio puede operar por más del 5% del FDR
	La SGR no puede recibir más del 5% del FDR en cheques de un mismo firmante
	Ningún socio puede operar si debe facturas por más del 10% del total de la línea asignada
	Un socio no puede ser aprobado como protector si es accionista de una empresa socia partícipe de la SGR
	Si una empresa comparte accionistas con otra empresa el total computado para el 5% del FDR es la suma de los riesgos vivos de ambas empresas


