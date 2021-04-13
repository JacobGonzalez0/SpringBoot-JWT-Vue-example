# Vue-Spring

In this repo you will find:

 - SpringBoot with JPA
 - JWT Token setup with Spring Security
 - Vue.js with VueX State Management

To setup the project simply run

    ./start.sh

This will download the npm packages if they are missing for the first time then run both springboot and vue.js development environment

## JWT

JWT is setup using this structure here
![enter image description here](https://lh3.googleusercontent.com/kUp6pgh-yBmpb5Jc6M4210ye24Nhbnygu7asZ8QB3M2_W8yXjrazYYnVd-1qkCfCpUMMEDq44d7C84fazOvBFeuJZ0wC30AwTxXQhYuUlMEWnU-HU2udmyaj4GT4JQxfZcmCf765Xl8cBZkAQuG1M7Ak8J-ls22ofn99MJSEcsHbq1hhpPQAsTkP5KsUdwe5oQnsyjm8NqESSdMxBSq1PqNKfNnpcg_wkEJtCaYkhjLkhhnjboN1OPQidIjklgowB0V_g3688rbnWzoUSlDTkryOiGq56FQbf7o9F5suBShQn5iyJs-v66RUiQ63_s_msFaw6EjbQ0IkeMC2dvjejnXyeCmY3Aopq25I5D_qsU55H24w3DAgUGfTCjOz20QK0AtVlLllh4hI1XB1_gLGXhvxq5agkScNAhGJX2uiaVHcdopY0TrEMVBnkrQzFCR3YW1iJrGPqPaWAaoZDOpYgPGTlrJK-gdeVdVBEfpJIg2T6fU9TBsktfFjnB8X8x2TJfVxEC0BlqvoFaLovV3RhQKvS_x9McbbZiUCBGVFLAXFG4W1EQ5-sr0RwjTtGfTtqb9tIz5-oPDI5sF--bfnGL_qAoQ6E_TfKNoaAcafup06dKdK64x9n7qdCMQO_plXFIW9zik0-f8F3KZDBqCry_SPeE4qv2nN_defzcZd4tyTu77PkQgnwhC1jsLF0RYdTJ-FwSuvn88dO9Su5bO2Qg=w677-h722-no?authuser=0)


JWT allows for the server to be stateless, letting us be free with any frontend framework we would like to use and extending support to app development in the future. With this setup there isnt much more needed to implement different outside a normal rest setup using session cookies. This reduces the load on the server as well.

## Vue.js

The vue.js setup is located in

    src/main/ui
all the contents are a normal npm setup and you can add any libraries needed or setup SASS. Replace this setup with a react or angular setup if needed. for deployment on a live server be sure to change the CORS allowed url in the `WebSecurityConfig.java` class.

## Deployment

Work in progress using nginx and using the reverse proxy to have the Java API routed to

    /api/
   