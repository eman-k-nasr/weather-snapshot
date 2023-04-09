# weather-snapshot
A simple app that lets users :
- take a photo. 
- add  current weather information (e.g. place name, temperature, weather condition,…) as an overlay text on his photo.
- share captured photo.
- view a history of all captured snapshots.
# Permissions Required :
- camera 
- location 
- internet
# project structure :
project consists of 8 modules 
* :app  <br />
The app module that contains any logic related to app level and depends on all feature modules and core modules.
* :camera,:weather,:history <br />
These modules are considered to be our features modules , they are specific modules which are scoped to handle a single responsibility in the app 
and can be later reused in any app 
* :database,:actions,:utils,:theme, <br />
Tese modules are considered to be our core modules ,they are common modules containing auxiliary code and specific dependencies 
that need to be shared between other modules in the app.
# Technology Stack :
* Coroutines (concurrency)
* Flow (reactive streams)
* Hilt (dependency injection)
* Jetpack compose (layout)
* Navigation Component Compose (navigation)
* Room (local database)
* Retrofit (network requests)
* Gson (parsing)
* Accompanist (permission handling)
* CameraX (capture photos)
* Coil (image loading)
# Screenshots 
<img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/1.jpg" width="200" height="400"> <img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/11.jpg" width="200" height="400">
<img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/2.jpg" width="200" height="400"> <img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/3.jpg" width="200" height="400"> <img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/5.jpg" width="200" height="400"> 
<img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/6.jpg" width="200" height="400"> <img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/8.jpg" width="200" height="400"> 
<img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/9.jpg" width="200" height="400"> <img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/10.jpg" width="200" height="400"> 
<img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/share1.jpg" width="200" height="400"> <img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/share2.jpg" width="200" height="400"> 
<img src="https://github.com/eman-k-nasr/weather-snapshot/blob/master/screenshots/12.jpg" width="200" height="400"> 
