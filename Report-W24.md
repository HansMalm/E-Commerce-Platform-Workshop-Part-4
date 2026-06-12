# Group Meeting Report – Week 24

## 1. Collaboration

We have collaborated by:

- Working together on all assigned tasks for Week 24.
- Supporting each other with debugging, reviewing pull requests, and clarifying responsibilities.
- Coordinating through the task sheet and group channel to ensure progress.
- Reviewing each other's work to maintain consistency across the controller layer.
- Following the updated branching routine agreed upon in Week 23, with all members pulling the latest code before pushing.

---

## 2. Individual Contributions

- **Aida** — Completed the Category Controller; added Javadoc comments to methods; merged PR #3, #5, #8, and #13.
- **Kristy** — Completed the Product Controller; extended `ProductService` and `ProductServiceImpl` with `findById`, `update`, and `delete`; added Javadoc comments; merged PR #2 and #10.
- **Jayani** — Completed the Customer Controller and missing DTOs; added Javadoc to the Customer Controller; added the SpringDoc/Swagger dependency to the project; updated the README; managed and merged PRs #1, #4, #7, #9, and #11.
- **Hans** — Managed the GitHub repository; completed the Global Exception Handler; reviewed and merged PRs; provided guidance on `@Tag` and `@Operation` Swagger annotations in the group channel.
- **Manjula** — Completed the Order Controller with validation and Javadoc; merged PR #12.
- **Alexander** — Completed API Documentation (Swagger UI) task; configured SpringDoc OpenAPI with Therapi Runtime Javadoc to surface Javadoc comments in the Swagger UI; created `OpenApiConfig` bean; confirmed Swagger UI is accessible and serving correctly.

---

## 3. Communication

Our communication for this week covered the following:

- Task distribution was agreed upon at the start of the session in the group channel, following the same structure as the workshop task sheet.
- Members communicated progress and completion in the group channel, allowing others to pull and continue without delays.
- Hans shared example code for `@Tag` and `@Operation` annotations to help members apply consistent Swagger documentation across all controllers.
- Alexander requested that all members add Javadoc comments to their controller methods so they would be surfaced in the Swagger UI — most members added these before their final push.
- Members confirmed completion and merge status in the channel, enabling smooth sequential integration.
- The group maintained a no-conflict merge streak throughout the day, thanks to the improved pull-before-push routine established in Week 23.

---

## 4. Decision-Making

- Distribute controller tasks one per member, mirroring the Part 4 workshop requirements.
- All members must pull the latest `feature/jpa-part4` branch before pushing to avoid merge conflicts.
- Javadoc comments should be added to all controller methods to enable automatic Swagger documentation via Therapi Runtime Javadoc.
- Use `@Tag` and `@Operation` annotations consistently across all controllers.
- The `feature/jpa-part4` branch acts as the integration branch for this workshop part; individual feature branches are merged into it via pull requests.

### 11 June — Meeting Decisions

- Confirmed task assignments and completed distribution for all Part 4 items.
- Agreed that Javadoc comments are preferred for describing endpoints, complementing the Swagger `@Operation` annotations.
- Confirmed the E-commerce App Part 4 controller layer was completed and all modules were running.
- Ensured DTOs, services, mappers, and controllers were consistent across all modules.

---

## 5. Challenges

- Some members were initially unfamiliar with Swagger annotations (`@Tag`, `@Operation`) and needed guidance before applying them.
- The Swagger UI artifact `springdoc-openapi-javadoc` did not exist in Maven Central — the correct dependency combination (`springdoc-openapi-starter-webmvc-ui` + `therapi-runtime-javadoc`) had to be resolved.
- MySQL was not available in the local environment, requiring a switch to an H2 in-memory datasource for local development and Swagger verification. which was reversed after confirming Swagger was working.
- DevTools hot-reload caused repeated restarts while dependencies were being updated, leading to a brief port 8080 conflict on relaunch.

---

## 6. Solutions and Improvements

We addressed the challenges by:

- Hans sharing Swagger annotation examples directly in the group channel so all members could apply them consistently.
- Correcting the SpringDoc dependency to `springdoc-openapi-starter-webmvc-ui` combined with `therapi-runtime-javadoc` and the `therapi-runtime-javadoc-scribe` annotation processor.
- Configuring the dev profile to use an H2 in-memory datasource, allowing the application to start and Swagger to be verified without a running MySQL instance.
- Stopping the conflicting Java process before relaunching the application for the final Swagger verification.
- Confirming all three endpoints: `/swagger-ui.html` (redirects to `/swagger-ui/index.html`, HTTP 200) and `/v3/api-docs` (HTTP 200, 9 312 bytes of OpenAPI JSON).

---

## 7. Next Steps

Our next planned actions are:

- Continue testing and refining the completed modules.
- Follow the updated branching routine to avoid merge conflicts.
- Prepare for the next workshop by reviewing the completed E-commerce App Part 4.
- Ensure all DTOs, services, mappers, and controllers remain consistent with the project structure.
- Consider adding integration tests for the REST endpoints.

---

## 8. Links

- **Repository:** <https://github.com/HansMalm/E-Commerce-Platform-Workshop-Part-4>
- **Task Sheet:** <https://docs.google.com/spreadsheets/d/1snSWDvNYB2crR6pDdyyAur4_iaSH7mX6hP5C1j6HVgc/edit?usp=sharing>

---

## 9. Commit History – Week 24 (11 June 2026)

| Hash | Author | Message |
|------|--------|---------|
| `5d4a267` | Aida Elena Farateseh | Merge PR #13 – feature/jpa-Category (add javadoc) |
| `9b569c5` | Aida Elena Faratseh | add javadoc |
| `383dc80` | Manjula | Merge PR #12 – feature/manjula/jpa-part4 |
| `739058b` | Manjula | implement order creation API with validation and Javadoc |
| `29e954c` | Jayani Athukorala | Merge PR #11 – feature/jpa-part4-readme |
| `2048328` | Jayani Athukorala | add javadoc in customer controller |
| `0d53d3b` | Kristy | Merge PR #10 – part4-productController-Kristy |
| `ef416c5` | Kristy Heijenk | Add Javadoc comments |
| `3c74529` | Jayani Athukorala | Merge PR #9 – feature/jpa-part4-readme |
| `48aebae` | Jayani Athukorala | import swagger dependency |
| `bfa2b38` | Aida Elena Farateseh | Merge PR #8 – feature/jpa-Category |
| `4751778` | Aida Elena Faratseh | add default swagger annotation with description |
| `d455829` | Jayani Athukorala | Merge PR #7 – feature/jpa-part4-readme |
| `0c9a7c5` | Jayani Athukorala | add swagger dependency |
| `4b047e4` | Haseq | Merge PR #6 – feature/jpa-part4-Hans-GlobalException |
| `74194ee` | Hans Malmefjäll | mod GlobalExceptionHandler.java |
| `94187ed` | Aida Elena Farateseh | Merge PR #5 – feature/jpa-Category |
| `5c08114` | Aida Elena Faratseh | add final to line 22 |
| `b9db95b` | Aida Elena Faratseh | add a final on line 22 |
| `11a22cd` | Jayani Athukorala | Merge PR #4 – feature/jpa-part4-readme |
| `94542db` | Jayani Athukorala | add read me |
| `92ef4cb` | Aida Elena Farateseh | Merge PR #3 – feature/jpa-Category |
| `b15418f` | Aida Elena Faratseh | add CategoryController |
| `701df3e` | Aida Elena Faratseh | add CategoryController |
| `4b047e4` | Hans Malmefjäll | Merge PR #6 – GlobalExceptionHandler |
| `74194ee` | Hans Malmefjäll | mod GlobalExceptionHandler.java |
| `16a620c` | Kristy | Merge PR #2 – part4-productController-Kristy |
| `9c2d1a6` | Kristy Heijenk | feat: add ProductController and extend ProductService with findById, update and delete |
| `97f60a1` | Jayani Athukorala | Merge PR #1 – feature/jpa-part4-customer-controller |
| `4efdf0f` | Jayani Athukorala | customer controller and missing dtos |

---

## 10. Group Members – Attendance Report (Group 2)

| Name | Attendance |
|------|-----------|
| Aida | 11 June – Week 24 |
| Alexander | 11 June – Week 24 |
| Manjula | 11 June – Week 24 |
| Kristy | 11 June – Week 24 |
| Hans | 11 June – Week 24 |
| Jayani | 11 June – Week 24 |

---

## Final Summary

All group members actively contributed to the Week 24 tasks and successfully completed the controller layer for the E-commerce App Part 4. Every controller — Customer, Product, Category, and Order — was implemented with proper Spring annotations, validation, and Javadoc comments. The Global Exception Handler was completed and the Swagger UI was configured, verified, and confirmed to be serving the full OpenAPI documentation with Javadoc descriptions at `/swagger-ui/index.html`.

The group continued to improve version control discipline from Week 23, with members pulling the latest branch before pushing and raising blockers in the group channel promptly. The session concluded with all 9 tasks marked as completed.

---

*12 June 2026*  
*Alexander*
