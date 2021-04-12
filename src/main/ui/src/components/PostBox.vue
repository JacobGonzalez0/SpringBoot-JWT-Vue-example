<template>
    <div class="card shadow m-2" style="max-width: 350px;">
        <img class="rounded w-100" :src="post.images[0].url">
        <div class="p-2">
            <h2>{{post.title}}</h2>
            <p>{{post.text}}</p>
        </div>
        <div class="d-flex justify-content-between align-items-center p-2">
            <div>{{post.date}}</div>
            <router-link :to="'/post/view/' + post.post_id">
                <button class="btn btn-primary"  >Read More <i class="fas fa-arrow-right"></i> </button>
            </router-link>
        </div>
    </div>
</template>

<script>


export default {
  name: 'PostBox',
  props:{
      post: Object
  },
  mounted(){
      //Parse date to UNIX formate
      let date = Date.parse(this.post.date)
      //format into something readable
      let d = new Date(date)
      this.post.date = d.getMonth() + "/" + d.getDate() + "/" + d.getUTCFullYear()
  }
  
  
}
</script>