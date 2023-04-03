<template>
  <article class="login">
     <div>
       <h2>
         회원가입
       </h2><div><h4>
<a>가입</a>
<a>약관동의</a>
<a>정보입력</a>
<a>가입완료</a>

</h4>
       </div>
       <h2>회원가입을 환영합니다.</h2>
       <h4>회원으로 가입하시면 다양한 혜택과<br>서비스를 이용하실 수 있습니다.</h4>
       <button type="button" @click="goAgree"><a>가입하기</a></button>

     </div>

     <div>
     <img v-bind:src="srcImg1"><h4>네이버 아이디로 로그인</h4></div>
     <div><img v-bind:src="srcImg2"><h4>카카오톡 아이디로 로그인</h4></div>
     </div>
   </article>
</template>

<script>
module.exports = {
    data: function() {
        return {
            srcImg1:'https://7dreamersmedia.blob.core.windows.net/wpmedia/2020/02/naver.png',
            srcImg2:'https://i.pinimg.com/originals/70/e8/ed/70e8edb8f187700949ab96830a3af4af.png'
        }
    },
    methods:{
      goAgree: function(){
        this.$router.push('/silhyun/join/agree')
      }
    }
}
</script>

<style src="/css/vue/join.css"></style>
