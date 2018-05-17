<template>
    <div id="addMovie">
        <el-button @click="backList">返回列表</el-button>

        <el-form style="margin-top:20px" ref="form" :model="product" label-width="80px">
           <el-input v-model="product.id" type="hidden"></el-input>
            <el-form-item label="商品名称">
                <el-input v-model="product.productName"></el-input>
            </el-form-item>
            <el-form-item label="价格">
                <el-input v-model="product.price"></el-input>
            </el-form-item>
            <el-form-item label="市场价格">
                <el-input v-model="product.marketPrice"></el-input>
            </el-form-item>
            <el-form-item label="库充">
                 <el-input v-model="product.commentNum"></el-input>
            </el-form-item>
            <el-form-item label="产地">
                 <el-input v-model="product.place"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">立即创建</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import api from "../const/url"
export default {
  name: 'add',
  data(){
    return {
        product:{}
    }
  },
  methods: {
      backList:function(){
          this.$router.push("/");
      },
      onSubmit:function(){
          this.$http.post(api.addProduct,this.product).then(response => {
              if(response.data.status == "success") {
                  this.$message({
                    message: '新增成功',
                    type: 'success'
                  });
                  this.$router.push("/");
              } else {
                  this.$message.error(response.data.message);
              }
          }).catch(error => {
              this.$message.error("系统提示:" + error.message);
          });
      }
      
  }
}
</script>
<style lang="less" scoped>
</style>