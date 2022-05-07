<template>
    <div>
            <h2> Collatz </h2>
            <form v-on:submit.prevent="submitForm">
                <div class="form-group">
                    <label for="bignumber">Big Number</label>
                    <input type="text" class="form-control" id="bignumber" placeholder="A big number" v-model="form.bignumber">
                </div>
                <div class="form-group">
                    <button class="btn btn-primary">Submit</button>
                </div>
                <div class="form-group">
                    Total iteraciones: {{ counter }}
                </div>
            </form>
    </div>
</template>
<script>
export default {
  name: 'Collatz',
  data() {
    return {
        form:{
            bignumber: null,
        },
        counter: null
    };
  },
  methods:{
      submitForm(){
          this.$axios.post('/.netlify/functions/api', this.form)
                 .then((res) => {                     
                     this.counter = res.data.counter
                 })
                 .catch((error) => {
                     // error.response.status Check status code
                     console.log(error)
                 }).finally(() => {
                     //Perform action in always
                 });
        }
    }
}
</script>