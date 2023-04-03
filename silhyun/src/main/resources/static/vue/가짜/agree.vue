<template>
  <article class="login">
    <div>
      <h2>
        회원가입
      </h2>
      <div>
        <h4>
          <a>가입</a>
          <a>약관동의</a>
          <a>정보입력</a>
          <a>가입완료</a>

        </h4>
      </div>

      <div>
        <input type="checkbox" id="all" class="checkbox_all" v-model="selectAll">
        <label for="all"><h4 v-bind:style="red">전체동의</h4></label>
      </div>
      <h4>필수 동의항목</h4>
      <div>

        <div>
          <div>
          <input type="checkbox" id="privacy1" value="1" class="checkbox_item" v-model="select">
          <label for="privacy1"><h5>실현하다 회원 이용 약관</h5></label></div>
          <h4>내용보기</h4>
        </div>
        <div>
          <div><input type="checkbox" id="privacy2" value="2" class="checkbox_item" v-model="select">
          <label for="privacy2"><h5>개인정보 수집 및 이용 동의</h5></label></div>
          <h4>내용보기</h4>
        </div>
        <h4>선택 동의항목</h4>
        <div>
          <div><input type="checkbox" id="privacy3" value="3" class="checkbox_item" v-model="select">
          <label for="privacy3"><h5>개인정보 수집 및 이용 동의</h5></label></div>
          <h4>내용보기</h4>
        </div>
        <div>
          <div><input type="checkbox" id="privacy4" value="4" class="checkbox_item" v-model="select">
          <label for="privacy4"><h5>마케팅 수신 동의</h5></label></div>
          <h4>내용보기</h4>
        </div>






      </div>
      <p v-bind:style="red">※ 정보수신에 동의하지 않으셔도 정상적인 서비스 이용이 가능합니다</p>

      <h5>거래정보∙결제/교환/환불 등과 관련된 내용은 거래안전을 위하여 수신동의 여부와 관계없이 발송됩니다</h5>

    <div>
    <button type="button" @click="goJoin"><a>처음으로</a></button>
    <button type="button" @click="goInfo"><a>동의하고 회원가입</a></button></div>
    </div>
  </article>
</template>

<script>
module.exports = {
    data: function() {
        return {
            red: {color : '#c80a1e'},
            select: []
        }
    }, 
    methods:{
        goJoin: function(){
            this.$router.push('/silhyun/join/start')
        },
        goInfo: function(){
            console.log(this.select.includes('1'))
            if(this.select.includes('1') && this.select.includes('2')){
                this.$router.push('/silhyun/join/info')
            }else{
                alert("필수 동의항목에 동의해 주세요")
            }
        }
    },
    computed:{
        selectAll: {
            get:function(){
                if(this.select.length == 4){
                  return true
                }
            },
            set:function(e){
                if(e){
                    for(i=1; i<=4; i++){
                        this.select.push(String(i))
                        console.log(this.select.includes('1'))
                    }
                }else{
                    this.select = []
                }
            }

        }
    }
}
</script>

<style src="/css/vue/agree.css"></style>
