<template>
  <div class="dataTable">
    <div>
      <el-button title="重新加载数据">
        <i class="el-icon-refresh-right"></i>
      </el-button>
      <el-button @click="exportExcel">导出数据</el-button>
    </div>
    <el-table id="tabledata" :data="tableData" border tooltip-effect="dark" fit>
      <!-- @selection-change="handleSelectionChange" ref="multipleTable"-->
      <el-table-column type="selection" style="width:0.1vmin, width:5vmax"></el-table-column>
      <el-table-column prop="tQuestionData" label="数据"></el-table-column>
      <el-table-column prop="submitter" label="提交人"></el-table-column>
      <el-table-column prop="submit_time" label="提交时间"></el-table-column>
      <el-table-column prop="write_time" label="填写时间（毫秒）"></el-table-column>
      <el-table-column prop="write_place" label="提交地理位置"></el-table-column>
      <el-table-column prop="address" label="地址" show-overflow-tooltip></el-table-column>
    </el-table>
  </div>
</template>

<script>
import FileSaver from 'file-saver'
import XLSX from 'xlsx'
export default {
  name: "dataTable",
  components: {},
  data() {
    return {
      tableData: [],
      formQuestion: [],
      multipleSelection: [],
    };
  },

  methods: {
    toggleSelection(rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    selectDatas(formId) {
      this.$qDApi.getSelectDatas({ formId: formId }).then((successResponse) => {
        this.tableData = successResponse.data;
        this.formQuestion = this.$store.getters.getFormQuestiona;
      });
    },
    exportExcel () {
      /* generate workbook object from table */
      var wb = XLSX.utils.table_to_book(document.querySelector('#tabledata'))
      /* get binary string as output */
      var wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
      try {
        FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), '新建文件夹.xlsx')
      } catch (e) { if (typeof console !== 'undefined') console.log(e, wbout) }
      return wbout
      },
  },
  mounted() {
    this.selectDatas(this.$store.getters.getOneForm.id);
  },
};
</script>

<style>
.dataTable {
  width: 100%;
  height: 100%;
  margin: 0 auto;
  /* overflow-y: scroll; auto不行，滚动条作用对象为body */
}
</style>