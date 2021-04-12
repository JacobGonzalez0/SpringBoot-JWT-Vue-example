<template>
    <div class="post">
        <div class="container">
            <div class="col py-5">
                <h1>
                    {{post.title}}
                </h1>
                <div class="d-flex justify-content-start d-flex">
                    <img style="max-width: 48px" class="rounded-circle me-2" :src="'/' + post.owner.userImageUrl" alt="">
                    <div>
                        <div>
                            {{post.owner.username}}
                        </div>
                        <div>
                            {{post.date}}
                        </div>
                    </div>
                </div>

                <div>
                   <img class="mx-0 m-md-2 w-100" :src="'/' + post.images[0].url" alt=""> 
                </div>

                <div >
                    {{post.text}}
                </div>

                <form action="#" th:object="${user}" method="post">
                    <div class="col justify-content-center align-items-center">
                        <h2 class="text-center p-3">
                           Comments
                        </h2>
                    </div>
                    <div class="col">                     
                        <div class="d-flex flex-column">
                            <label class="my-1" for="text">Comment</label>
                            <input class="form-control my-1" type="text" name="text">
                            <button id="submitComment" class="btn btn-primary">Comment</button>
                        </div>
                    </div>
                    <div class="col my-4" id="comments">
                       
                    </div>
                    
                </form>
                
            </div>
        </div>

    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: "post" ,
    components:{
     
    },
    data: function(){
        return {
            post: Object
        }
    },
    methods:{
        getPost: function(){
            let self = this;
            let post_id = -1;
            if(this.$route.params.post_id){
                post_id = this.$route.params.post_id
            }
            axios.get('http://localhost:8080/post/' + post_id).then( response =>{
                    console.log(response.data)
                    self.post = response.data
                })
            }
    },
    mounted(){
        this.getPost();
    }
}
</script>
