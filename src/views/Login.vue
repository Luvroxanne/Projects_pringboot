<template>
  <div class="login-container">
    <div class="login-box">
      <h2 class="title">明道云</h2>
      <div class="login-form">
        <h3>登录</h3>
        <div class="form-item">
          <input 
            type="text" 
            v-model="loginForm.username" 
            placeholder="手机号或邮箱" 
          />
        </div>
        <div class="form-item">
          <input 
            type="password" 
            v-model="loginForm.password" 
            placeholder="密码" 
          />
        </div>
        <div class="remember-row">
          <label>
            <input type="checkbox" v-model="loginForm.remember" />
            下次自动登录
          </label>
          <a href="#" class="forget-pwd">忘记密码?</a>
        </div>
        <button class="login-btn" @click="handleLogin">登 录</button>
        <div class="other-login">
          <p>使用其他方式登录</p>
          <div class="login-methods">
            <div class="method-item" @click="thirdPartyLogin('wechat')">
              <img src="@/assets/wechat.png" alt="微信登录" />
              <span>微信登录</span>
            </div>
            <div class="method-item" @click="thirdPartyLogin('qq')">
              <img src="@/assets/qq.png" alt="QQ登录" />
              <span>QQ登录</span>
            </div>
          </div>
        </div>
        <div class="register-link">
          <a href="#" @click="goToRegister">注册新账号</a>
          <div class="language-select">
            <span>CN</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
        remember: false
      }
    }
  },
  methods: {
    handleLogin() {
      // 调用后端登录接口
      this.$axios.post('/api/login', this.loginForm)
        .then(res => {
          if (res.data.code === 200) {
            this.$router.push('/dashboard')
          }
        })
        .catch(err => {
          console.error(err)
        })
    },
    thirdPartyLogin(type) {
      // 处理第三方登录
      console.log('第三方登录:', type)
    },
    goToRegister() {
      this.$router.push('/register')
    }
  }
}
</script>

<style scoped>
.login-container {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f5f5f5;
}

.login-box {
  width: 400px;
  padding: 40px;
  background: #fff;
  border-radius: 4px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.title {
  text-align: center;
  color: #1890ff;
  margin-bottom: 30px;
}

.form-item {
  margin-bottom: 20px;
}

.form-item input {
  width: 100%;
  height: 40px;
  padding: 0 15px;
  border: 1px solid #dcdfe6;
  border-radius: 4px;
  outline: none;
}

.remember-row {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.login-btn {
  width: 100%;
  height: 40px;
  background-color: #1890ff;
  border: none;
  border-radius: 4px;
  color: white;
  font-size: 16px;
  cursor: pointer;
}

.other-login {
  margin-top: 20px;
  text-align: center;
}

.login-methods {
  display: flex;
  justify-content: center;
  gap: 20px;
  margin-top: 15px;
}

.method-item {
  cursor: pointer;
}

.register-link {
  margin-top: 20px;
  display: flex;
  justify-content: space-between;
}
</style> 