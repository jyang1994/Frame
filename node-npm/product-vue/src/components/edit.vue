<template>
    <div id="editMovie">
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
                <el-button type="primary" @click="onSubmit">修改</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import api from "../const/url"
export default {
  name: 'edit',
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
          this.$http.put("/product/"+this.product.id,this.product).then(response => {
              if(response.data.status == "success") {
                  this.$message.success("修改成功");
                  this.$router.push("/");
              } else {
                  this.$message.error(response.data.message);
              }
          }).catch(error => {
              this.$message.error("系统提示:" + error.message);
          });
      }
  },
  mounted:function(){
      var id = parseInt(this.$route.params.id);
      console.log(id)
      this.$http.get("/product/"+id).then(response=>{
          this.product = response.data;
      }).catch(error=>{
          this.$message.error("系统提示:" + error.message);
      });
  }
}
</script>
<style lang="less" scoped>
</style>