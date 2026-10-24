
const assert = require("node:assert/strict");

const {
    firstNonRepeatingChar,
    findTwoSum,
    countLeadsByStatus
} = require("./solutions");


assert.equal(firstNonRepeatingChar("aabbcdd"), "c");
assert.equal(firstNonRepeatingChar("swiss"), "w");
assert.equal(firstNonRepeatingChar("aabb"), null);
assert.equal(firstNonRepeatingChar(""), null);
assert.equal(firstNonRepeatingChar("aAb"), "b");
assert.equal(firstNonRepeatingChar("aA!"), "!");
assert.equal(firstNonRepeatingChar("  a"), "a");


assert.deepEqual(findTwoSum([2, 7, 11, 15], 9), [0, 1]);
assert.deepEqual(findTwoSum([3, 2, 4], 6), [1, 2]);
assert.deepEqual(findTwoSum([3, 3], 6), [0, 1]);
assert.equal(findTwoSum([1, 2, 3], 10), null);
assert.deepEqual(findTwoSum([0, 4, 3, 0], 0), [0, 3]);


const leads = [
    { name: "Alice", status: "NEW" },
    { name: "Bob", status: "CONTACTED" },
    { name: "Charlie", status: "NEW" },
    { name: "David", status: "QUALIFIED" }
];

assert.deepEqual(countLeadsByStatus(leads), {
    NEW: 2,
    CONTACTED: 1,
    QUALIFIED: 1
});


assert.deepEqual(countLeadsByStatus([]), {});


assert.equal(leads.length, 4);
assert.equal(leads[0].status, "NEW");

console.log("All JavaScript tests passed!");
