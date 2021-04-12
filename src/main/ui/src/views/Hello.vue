<template>
    <div>
        Test!:
        <div v-cloak>
            {{test}}
        </div>
        <span v-cloak>
            
        </span>
        
    </div>
</template>

<script>
import axios from 'axios';
import { authHeader } from '../helpers/auth-header';

export default {
    data: function(){
        return{
            test: " "
        }
    },
    mounted(){
        console.log(authHeader())
        axios.get("http://localhost:8080/hello", authHeader()).then( res =>{
            console.log(res)
            this.test = res.data
        })
    }
}
</script>

<style scoped>
    [v-cloak] > * { display:none }
    [v-cloak]::before { content: "loading…" }
</style>