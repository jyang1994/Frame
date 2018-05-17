<template>
  <div class="home">
       <el-button type="primary" @click="addProduct">新增商品</el-button>
       <div style="margin-top: 20px">
     <el-button @click="delSelection">批量删除</el-button>
   
  </div>
        <el-table
        :data="products"
        style="width: 100%" 
         @selection-change="handleSelectionChange">
       
           <el-table-column
                type="selection"
                width="55">
            </el-table-column>

            <el-table-column
                prop="productName"
                label="商品名称">
            </el-table-column>
            <el-table-column
                prop="price"
                label="价格"
                width="80">
            </el-table-column>
            <el-table-column
                prop="marketPrice"
                label="市场价格"
                width="100">
            </el-table-column>
            <el-table-column
                prop="commentNum"
                label="库存"
                width="100">
            </el-table-column>
            <el-table-column
                prop="place"
                label="产地">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                    size="mini"
                        @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button
                    size="mini"
                    type="danger"
                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
            background
            layout="prev, pager, next,total"
            :total="total"
            :current-page="currentPage"
            @current-change="pageData">
        </el-pagination> 
  </div>
</template>

<script>
import api from "../const/url"
export default {
    name:"home",
    data() {
        return {
            products:[],
            total:0,
            currentPage:1,
            multipleSelection: []
        }
    },
    methods:{
        addProduct:function(){
            this.$router.push("/new");
        },

        delSelection:function(){
             this.$confirm("确定要删除该记录吗?").then(()=>{
            for(var i = 0 ; i < this.multipleSelection.length;i++){
                 var id = this.multipleSelection[i].id;
           
               this.$http.delete("/product/"+id).then(response=>{
                 if(response.data.status == "success") {
                     this.$message.success("删除成功");
                    
                   
                    this.products.splice(this.multipleSelection[i],1);
                 }
              }).catch(error=>{
                 this.$message.error("系统提示:" + error.message);
               });
               }
           }).catch(()=>{});
          
            
            console.log(this.multipleSelection)
        },


         handleSelectionChange(val) {
        this.multipleSelection = val;
      },
         handleDelete:function(index,row){
           var id = row.id;
           this.$confirm("确定要删除该记录吗?").then(()=>{
               this.$http.delete("/product/"+id).then(response=>{
                 if(response.data.status == "success") {
                     this.$message.success("删除成功");
                    
                    this.products.splice(index,1);
                 }
              }).catch(error=>{
                 this.$message.error("系统提示:" + error.message);
               });
           }).catch(()=>{});
          },
         handleEdit:function(index,row){
                var id = row.id;
                this.$router.push("/edit/"+id);
         },
         pageData:function(pageNo){
             this.currentPage = pageNo;
             this.loadData(this.currentPage)

         },

         loadData:function(pageNum){
             
            this.$http.get(api.productHome+"/?p=" + pageNum).then(response => {
                this.products = response.data.result.list;
            
                this.total = response.data.result.total;


            }).catch(error => {
                this.$message.error("系统提示:" + error.message);
            });
        }

    },
    mounted:function(){
        this.loadData(this.currentPage)
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less" scoped>

</style>
