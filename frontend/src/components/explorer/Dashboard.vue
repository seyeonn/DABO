<template>
  <div>
    <h-breadcrumb title="Explorer"></h-breadcrumb>
    <div class="main-content container">
      <!-- 대시보드 개요 시작 -->
      <div id="dashboard-overview" class="row">
        <div class="col-md">
          <div class="dashboard-item bg-info">
            <h4 class="label">LATEST BLOCK</h4>
            <span>{{ latestBlock }}</span>
          </div>
        </div>
        <div class="col-md">
          <div class="dashboard-item bg-secondary">
            <h4 class="label">TRANSACTIONS</h4>
            <span>{{ latestTxCount }}</span>
          </div>
        </div>
      </div>

      <div id="data-preview" class="row">
        <div id="blocks" class="col-lg-6">
          <div class="card shadow-md">
            <div class="card-header">Blocks</div>
            <div class="card-body">
              <block-list countToShow="3" @updated="updateLatestBlock">
              </block-list>
              <div class="row">
                <div class="col-md-12">
                  <router-link
                    to="/exBlockChain/blocks"
                    class="btn btn-primary btn-block"
                    >View All</router-link
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
        <div id="transactions" class="col-md-6">
          <div class="card shadow-sm">
            <div class="card-header">Transactions</div>
            <div class="card-body">
              <tx-list countToShow="3" @updated="updateLatestTxCount"></tx-list>
              <div class="row">
                <div class="col-md-12">
                  <router-link
                    to="/exBlockChain/txes"
                    class="btn btn-primary btn-block"
                    >View All</router-link
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BlockList from '@/components/explorer/BlockList';
import TxList from '@/components/explorer/TxList';

export default {
  //eslint-disable-next-line
  name: 'Dashboard',
  components: {
    BlockList,
    TxList,
  },
  data() {
    return {
      latestBlock: 'NULL',
      latestTxCount: 'NULL',
    };
  },
  methods: {
    updateLatestBlock(blockNum) {
      this.latestBlock = blockNum;
    },
    updateLatestTxCount(count) {
      this.latestTxCount = count;
    },
  },
};
</script>

<style>
.dashboard-item {
  padding: 20px;
}
.dashboard-item h4 {
  font-size: 16px;
  font-weight: bold;
  opacity: 0.6;
}

.dashboard-item span {
  font-size: 20px;
}

#data-preview {
  margin-top: 30px;
  margin-bottom: 30px;
}
</style>
