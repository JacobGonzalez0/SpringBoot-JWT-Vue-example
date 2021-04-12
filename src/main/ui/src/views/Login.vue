<template>
  <div class="container">

      
      <div class="row">
        <div class="col-lg-6 offset-lg-3 col-sm-10 offset-sm-1">
          <form
            class="text-center border border-primary p-5"
            style="margin-top:70px;height:auto;padding-top:100px !important;"
            @submit.prevent="loginUser"
          >
            <input
              type="text"
              id="username"
              class="form-control mb-5"
              placeholder="username"
              v-model="login.username"
            />
            <!-- Password -->
            <input
              type="password"
              id="password"
              class="form-control mb-5"
              placeholder="Password"
              v-model="login.password"
            />
            <p>
              Dont have an account? Click
              <router-link to="/register"> here </router-link> to sign up
            </p>
            <!-- Sign in button -->
            <center>
              <button class="btn btn-primary btn-block w-75 my-4" type="submit">
                Sign in
              </button>
            </center>
          </form>
        </div>
      </div>
  </div>
</template>
<script>
import axios from 'axios';


export default {

  data() {
    return {
      login: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    async loginUser() {
      try {
        console.log(this.login)
        axios.post("http://127.0.0.1:8080/authenticate", this.login ).then( response =>{
          let token = response.data.jwt;
          localStorage.setItem("user", token);
        })        
      } catch (err) {
        console.log(err);
      }
    }
  }
};
</script>
