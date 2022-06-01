<p align= "center">
            <img src ="https://play-lh.googleusercontent.com/i81CCkpNfExlQVZer00lWsDas1b_0nSNV4UZht10pitn3-oyoV7Mx08CSIrlkWRPYA=w240-h480-rw", width ="20%">
</p>

<p>
    <h1 align="center">
        <a href="https://play.google.com/store/apps/details?id=com.mac.whatkilometers">
            What Kilometers (JAVA) by Saurabh Kumar<br>PlayStore handle :- imSoloDeveloper
        </a>
    </h1>
</p>


<p align="center">
    <a href="https://play.google.com/store/apps/details?id=com.mac.whatkilometers">
        <img src="https://travis-ci.org/steverichey/google-play-badge-svg.svg?branch=master" alt="Build status">
    </a>
    <a href="https://github.com/dev-iamsaurabh/WhatKilometers/blob/master/LICENSE">
        <img src="https://img.shields.io/badge/License-MIT-lightgrey.svg" alt="License: MIT">
    </a>
</p>

<p align="center">
  • <a href="#about">About</a>
  • <a href="#features">Features</a>
  • <a href="#available-on">Available on</a>
  • <a href="#license">License</a>


</p>



## About
What Kilometers is a distance measuring app between to places(Locality, Town, Cities , Countries). You have to just enter the name of your location and destination
and it will return the distance in Integer and Floating value.<br>
I am not using Google map sdk or any kind of API to do that. Rather than I am SCRAPPING Google results.<br>
What i am doing is, I am using JSOUP library for android which Scraps the google results.<br>
Then with the help of Split funtion in java i am spliting the String results and  I look for require output and when its done , the App shows the distance reults to user in miles or KM.<br>

Challenges and fixes i have faced:- <br>
1- They are many times the results comes in miles rather km.<br>
2- The Strings which return, we have to traverse every letter and split them and then join them again.<br>
3- Control over miles and km.<br>
4- Whenever you try to scrap results in India it will show the results in KM but when you try to search international Places you will get the results in miles.<br>
5- To fix this just convert miles in KM when ever it contians miles in the String results.<br>

Final words:- You can scrap google results and with help of String spliting and String concatenation in JAVA you can control all the things.<br>

****WARNING :- DO NOT SCRAP SO MUCH OF DATA FROM GOOGLE AT A TIME => OTHERWISE THEY WILL TEMPORARLY BLOCK YOUR IP.



## Features

You can get distance between two cities without using any kind of Google map sdk or API's.<br>
You will learn web scrapping with help of JSOUP library.<br>


## Available on

<p align="center">
<a href="https://play.google.com/store/apps/details?id=com.mac.whatkilometers">
<img src="https://cdn.jsdelivr.net/gh/dev-iamsaurabh/BMICalculator/play.svg" width="50%">
</a>
</p>


## License

Unless covered under some other license, all content in this repository is shared under an MIT license. See [license.md](./license.md) for details.

Google Play and the Google Play logo are trademarks of Google Inc. Be sure to read the [Branding Guidelines](https://developer.android.com/distribute/tools/promote/brand.html) and contact Google via the [Android and Google Play Brand Permissions Inquiry form](https://support.google.com/googleplay/contact/brand_developer) if you have any questions. SVGs in this repository were generated from files provided by Google [here](https://play.google.com/intl/en_us/badges/) and they have all the copyrights and trademarks and whatevs.

  
