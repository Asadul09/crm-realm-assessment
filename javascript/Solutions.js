
function firstNonRepeatingChar(str) {
    const counts = new Map();

    for (const char of str) {
        const normalized = char.toLowerCase();
        counts.set(normalized, (counts.get(normalized) || 0) + 1);
    }

    for (const char of str) {
        if (counts.get(char.toLowerCase()) === 1) {
            return char;
        }
    }

    return null;
}

function findTwoSum(nums, target) {
    const seen = new Map();

    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];

        if (seen.has(complement)) {
            return [seen.get(complement), i];
        }

        seen.set(nums[i], i);
    }

    return null;
}

function countLeadsByStatus(leads) {
    const counts = {};

    for (const lead of leads) {
        counts[lead.status] = (counts[lead.status] || 0) + 1;
    }

    return counts;
}

module.exports = {
    firstNonRepeatingChar,
    findTwoSum,
    countLeadsByStatus
};
