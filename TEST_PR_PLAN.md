# testGuardAI 提交计划

这份计划用于把审查样例拆成 3 轮 PR，分别验证单点命中、多点命中和误报控制。

## Round 1：单点命中验证

建议分支名：

`test/single-skill-fixtures`

建议 PR 标题：

`test: add single-skill review fixtures`

建议本轮提交文件：

- `review-fixtures/round1-single/python/logging_privacy_bad.py`
- `review-fixtures/round1-single/python/exception_observability_bad.py`
- `review-fixtures/round1-single/python/secret_leak_bad.py`
- `review-fixtures/round1-single/python/path_traversal_bad.py`
- `review-fixtures/round1-single/python/command_injection_bad.py`
- `review-fixtures/round1-single/python/weak_crypto_bad.py`
- `review-fixtures/round1-single/java/ApiOrderController.java`
- `review-fixtures/round1-single/java/PaymentConsumer.java`
- `review-fixtures/round1-single/java/OrderSettlementService.java`
- `review-fixtures/round1-single/java/RepositoryPermissionController.java`

本轮目标：

- 验证每条技能 / 规则是否至少能命中主问题
- 观察评论定位、严重级别和建议文本是否合理
- 先看召回，不急着追求完全无误报

## Round 2：多问题混合命中

建议分支名：

`test/mixed-risk-fixtures`

建议 PR 标题：

`test: add mixed-risk multi-hit fixtures`

建议本轮提交文件：

- `review-fixtures/round2-mixed/python/batch_import_service.py`
- `review-fixtures/round2-mixed/java/CheckoutFacade.java`

本轮目标：

- 验证多条技能同时命中时的排序和展示
- 验证规则治理动作是否会叠加生效
- 验证评论数量较多时页面和插件展示是否还能看清

## Round 3：误报与边界验证

建议分支名：

`test/safe-boundary-fixtures`

建议 PR 标题：

`test: add safe boundary fixtures for false-positive control`

建议本轮提交文件：

- `review-fixtures/round3-safe/python/safe_download_service.py`
- `review-fixtures/round3-safe/java/SafeOrderController.java`

本轮目标：

- 验证正常实现是否会被误报
- 验证 LLM 判定与技能路由是否能压住噪音
- 验证规则不会因为关键词存在而无脑触发

## 推荐执行顺序

1. 先发 Round 1，看单点命中。
2. 再发 Round 2，看多命中与展示效果。
3. 最后发 Round 3，看误报控制。

## 备注

- 如果你想验证“重新审查”能力，建议在 Round 1 合并后再基于同一仓库继续发 Round 2、Round 3。
- 如果你想验证“建议是否被修复”的闭环，可以在后续再补一轮 `fix:` PR，针对 Round 1 的问题逐个修复。
