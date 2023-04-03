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

    <!--아이디/비밀번호/이름부분-->
      <div class="inputInfo">
        <input type="text" placeholder="아이디" class="sm" v-model="id">
        <span class="idChk"></span>
        <!--회원가입 유효성 검사 위해 //true, false-->
        <input type="hidden" v-model="boolChkId">
    </div>
    <div class="inputInfo">
        <input type="password" placeholder="비밀번호 8~15자의 영문, 숫자, 특수문자 조합" v-model="pwd">
        <span class="pwdLengthck"></span>
        <input type="password" placeholder="비밀번호 확인" v-model="pwdck">
        <span class="pwdChk"><span>
        <!--회원가입 유효성 검사 위해 //true, false-->
        <input type="hidden" v-model="boolChkPwd">
        <input type="text" placeholder="이름" class="sm" v-model="name">
    </div>

    <!--아이디/비밀번호/이름부분 끝-->

    
       <!--연락처-->
      <div id="tel">
        <select v-model="tel1">
            <option v-for="(item, index) in telList"
                    v-bind:key="index"
                    v-bind:value="item">
                {{item}}
            </option>
        </select>

        <input type="text" v-model="tel2">
        <input type="text" v-model="tel3">

      </div>
      <!--연락처끝-->

    
    <!--이메일 부분-->
      <div id="email">
        <input type="text" placeholder="이메일(아이디)" v-model="emailId"><h5>@</h5>
        <input type="text" placeholder="직접입력" v-model="email">
        <select v-model="selectE">
          <option value="">
            직접입력
          </option>
          <option v-for="(item, index) in eList"
                v-bind:key="index"
                v-bind:value="item">
            {{item}}
          </option>
        </select>
      </div>
      
    <div id="chk">
    <input type="text" placeholder="인증번호" v-model="ckno">
    <input type="button" value="인증번호받기" v-bind:style="showBtn1">
    <input type="button" value="인증하기" v-bind:style="showBtn2">
    </div>
    <!--이메일 부분 끝-->



      <hr><div id="choi"><h4>선택입력 사항</h4></div>

    <!--생년월일 성별-->
      <div id="birth">
        <!-- 생년월일 -->
        <select v-model="selectY">
            <option value="">연도</option>
          <option v-for="(item, index) in yList"
                  v-bind:key="index"
                  v-bind:value="item.value">
                {{item.text}}
          </option>
        </select>
        <select v-model="selectM">
          <option value="">월</option>
          <option v-for="(item, index) in mList"
                  v-bind:key="index"
                  v-bind:value="item.value">
                {{item.text}}
          </option>
        </select>
        <select v-model="selectD">
          <option value="">일</option>
          <option v-for="(item, index) in dList"
                  v-bind:key="index"
                  v-bind:value="item.value">
                {{item.text}}
          </option>        
        </select>
        <!--생년월일 끝-->

        <div id="gender">
          <label for="join"><input type="radio" v-model="gen" value="f">
            <h5>여자</h5>
          </label>
          <label for="join"><input type="radio" v-model="gen" value="m">
            <h5>남자</h5>
          </label>
        </div>
      </div>
       <!--생년월일 성별끝-->
       <div class="inputInfo">
       <input type="text" placeholder="추천인아이디" class="sm" v-model="rcomr"> 
       <h5>* 추천인 아이디 작성시 친구추천 포인트 1000p를 드립니다.</h5>
       </div>

      <div>
        <button @click="goJoin"><a>처음으로</a></button>
        <button @click="goHello"><a>동의하고 회원가입</a></button></div>
    </div>
  </article>
</template>

<script>
$(document).ready(function(){
    var date = new Date()
    var selYear = date.getFullYear()

    $('#year').val(selYear)
    $('#year').change(function(){
        var chgYear = $(this).val()
        $('#year').val(chgYear)
    })
    
})

module.exports = {
    data: function() {
        return {
            id:'',
            pwd:'',
            pwdck:'',
            name:'',
            selectY:'',
            yList:[],
            selectM:'',
            mList:[],
            selectD:'',
            dList:[],
            seletTel:'010',
            tel1:'010',
            tel2:'',
            tel3:'',
            telList:['010', '011', '016', '017', '019'],
            selectE:'',
            eList:['naver.com', 'nate.com', 'daum.com', 'hanmail.com', 'gmail.com'],
            emailId:'',
            email: '',
            showBtn1: {display : ''},
            showBtn2: {display : 'none'},
            ckno:'',
            gen:'',
            rcomr:'',
            boolChkId:'false',
            boolChkPwd:'false'
            
        }
    },
    created(){
        const nowYear = new Date().getFullYear()
        for(let i = 0; i<100; i++){
            let yyyy = nowYear - i
            this.yList.push({value: yyyy, text: yyyy})
        }
        for(let i=1; i<13; i++){
            this.mList.push({value: i, text: i})
        }
        for(let i=1; i<32; i++){
            this.dList.push({value: i, text: i})
        }
    },
    methods: {
        goJoin:function(){
            this.$router.push('/silhyun/join/start')
        },
        goHello:function(){
            //여기에 axios호출해서 중복체크된후 중복값없음 넘어가자
            this.$router.push('/silhyun/join/hello')
        }
    },
    watch: {
        selectE:function(e){
            this.email = e
        }
    }
}
</script>


<style src="/css/vue/info.css"></style>