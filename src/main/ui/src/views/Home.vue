<template>
  <div class="home">
    <div class="d-flex flex-wrap justify-content-evenly" v-cloak v-bind:key="post.post_id" v-for="(post) in posts">
      <PostBox :post="post"></PostBox>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

import PostBox from "@/components/PostBox.vue"
import axios from 'axios';


export default {
  name: 'Home',
  components: {
   PostBox
  },
  data: function(){
    return{
      posts: Array
    }
  },
  methods: {
    getPosts: function (){
      let self = this;
      axios.get('http://localhost:8080/post/all').then( response =>{
        self.posts = response.data
        
      })
    }
  },
  mounted() {
    this.getPosts();
  }
}
</script>
