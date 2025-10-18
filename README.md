# 🌤️ AsyncWeatherApp  
**Proyecto académico - Programación Asíncrona en Android con Kotlin Coroutines y Retrofit**

---

## 📱 Descripción General
**AsyncWeatherApp** es una aplicación Android desarrollada en **Kotlin**, diseñada para demostrar el uso de **programación asíncrona** mediante **Kotlin Coroutines** y **Retrofit**.  
La app consulta datos meteorológicos en tiempo real desde la API pública de **[Open Meteo](https://api.open-meteo.com/)**, evitando el bloqueo de la interfaz de usuario gracias al uso de **hilos y corrutinas** correctamente gestionados.

---

## 🎯 Objetivo del Proyecto
Aplicar los conceptos de **asincronía, concurrencia y arquitectura MVVM**, permitiendo la ejecución de tareas en segundo plano (como peticiones HTTP) sin afectar la experiencia del usuario.

---

## ⚙️ Tecnologías y Librerías Utilizadas
- **Kotlin** – Lenguaje principal  
- **Android Jetpack Components** – ViewModel, LiveData, Lifecycle  
- **Retrofit 2** – Cliente HTTP para consumir la API  
- **Kotlin Coroutines** – Manejo asíncrono de tareas (`launch`, `async`, `await`, `withContext`)  
- **Material Design 3** – Interfaz moderna y adaptable  
- **Gson Converter** – Conversión automática de JSON a objetos Kotlin  

---

## 🌐 API Utilizada
**Open-Meteo API**  
Ejemplo de endpoint:
https://api.open-meteo.com/v1/forecast?latitude=-33.45&longitude=-70.66&current_weather=true
📍 Retorna el clima actual de Santiago, Chile (temperatura, velocidad del viento, código de clima, etc.)

---

## 🚀 Funcionamiento
1. El usuario presiona el botón **“Consultar Clima”**.  
2. Se muestra un **CircularProgressIndicator** mientras se ejecuta la corrutina.  
3. En segundo plano, el **ViewModel** lanza una solicitud HTTP usando **Retrofit** y **Dispatchers.IO**.  
4. Cuando la respuesta se recibe, los datos son enviados al hilo principal (**Dispatchers.Main**) para actualizar la UI.  
5. La información del clima se muestra en pantalla.  

---

👨‍💻 Autor

Jose Muñoz <br>
JM Devs<br>
Desarrollador Android en formación | Kotlin | MVVM | Firebase | Material Design



